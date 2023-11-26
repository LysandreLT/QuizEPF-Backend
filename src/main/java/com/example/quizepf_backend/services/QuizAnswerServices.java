package com.example.quizepf_backend.services;

import com.example.quizepf_backend.DAO.QuizAnswerDAO;
import com.example.quizepf_backend.DAO.QuizQuestionDAO;
import com.example.quizepf_backend.DAO.QuizUserDAO;
import com.example.quizepf_backend.DTO.QuizAnswerDto;
import com.example.quizepf_backend.DTO.mapper.QuizAnswerMapper;
import com.example.quizepf_backend.exceptions.AppException;
import com.example.quizepf_backend.models.*;
import com.example.quizepf_backend.models.enums.QuestionType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizAnswerServices {

    private final QuizAnswerDAO quizAnswerDao;
    private final QuizQuestionDAO quizQuestionDao;
    private final QuizUserDAO quizUserDao;
    public List<QuizAnswer> findAll() {
        Iterable<QuizAnswer> it = quizAnswerDao.findAll();
        List <QuizAnswer> quizzes = new ArrayList<>();
        it.forEach(quizzes::add);
        return quizzes ;
    }
    public List<QuizAnswer> getQuizAnswersByQuizId(Long quizId) {
        Iterable<QuizAnswer> it = quizAnswerDao.findQuizAnswersByQuizId(quizId);
        List<QuizAnswer> quizAnswers = new ArrayList<>();
        it.forEach((quizAnswer -> {
            //to hide the answer in the browser
            /*quizAnswer.setIsTrue(false);
            if (quizAnswer.getQuizQuestion().getQuestionType() == QuestionType.WRITTENANSWER){
                quizAnswer.setAnswer("");
            }*/
            // comment everything between the 2 comments to test if score is working properly
            quizAnswers.add(quizAnswer);
        }));
        return quizAnswers;
    }
    @Transactional
    public int checkAnswers(List<QuizAnswer> userAnswers, Long quizId, Long userId){


        /* renvoie le score, la liste des bonnes réponses par questions?
        * {
        * score : 0,
        * answers? : [{...}]
        * }
        * */

        int score = 0;

        //fetch all questions by quizId
        List<QuizQuestion> quizQuestions = quizQuestionDao.findQuizQuestionsByQuizId(quizId);

        for (QuizQuestion quizQuestion: quizQuestions){
            //fetch answers foreach questions
            List<QuizAnswer> quizAnswers = quizAnswerDao.findQuizAnswersByQuizQuestionId(quizQuestion.getId());
            // filter userAnswers by QuestionId
            List<QuizAnswer> userAnswersByQuestionId = userAnswers.stream()
                    .filter(quizAnswer -> quizAnswer.getQuizQuestion().getId().equals(quizQuestion.getId()))
                    .toList();
            // add to score  -> calculate score for each type of questions
            score += (int)calculateQuestionScore(userAnswersByQuestionId, quizAnswers, quizQuestion);
        }

        //save score (new quizUser)
        QuizUser quizUser = new QuizUser.Builder()
                        .quiz(new Quiz.Builder().id(quizId).build())
                        .user(new User.Builder().id(userId).build())
                        .score(score)
                .build();

        quizUserDao.save(quizUser);

        return score;
    }

    public float calculateQuestionScore(List<QuizAnswer> userQuizAnswers, List<QuizAnswer> quizAnswers, QuizQuestion quizQuestion){
        float score = 0;
        boolean ignoreQuestion = false;
        float numberOfCorrectAnswers = 0;
        // foreach user answer of question
        for (QuizAnswer userQuizAnswer: userQuizAnswers) {
            if (ignoreQuestion)
                break;

            // get the right answer
            QuizAnswer currAnswer = quizAnswers.stream().filter(qa -> qa.getId() == userQuizAnswer.getId()).toList().get(0);

            //compare result and add to score if correct
            if (quizQuestion.getQuestionType() == QuestionType.WRITTENANSWER){
                // if user answer = answer -> add to score
                if (userQuizAnswer.getAnswer().equals(currAnswer.getAnswer())){
                    score += quizQuestion.getQuestionValue();
                }
            } else if (quizQuestion.getQuestionType() == QuestionType.SINGLECHOICE) {
                // if user answer is correct -> add to score
                if (currAnswer.isTrue() == userQuizAnswer.isTrue()){
                    score = quizQuestion.getQuestionValue();
                }
            }else {
                //check if user answer == true while answer is false -> score for this question = 0
                if (userQuizAnswer.isTrue() && !currAnswer.isTrue()){
                    score = 0;
                    ignoreQuestion = true;
                }
                else if (userQuizAnswer.isTrue() && currAnswer.isTrue()){
                    // count number of correct answers for the question
                    numberOfCorrectAnswers +=1;
                }
            }
        }

        if (quizQuestion.getQuestionType() == QuestionType.QCM){
            //-> score = question value * (number of correct answers / total number of answers)
            score = (float)quizQuestion.getQuestionValue() * (numberOfCorrectAnswers / quizAnswers.stream().filter(QuizAnswer::isTrue).count());
        }
        return score;
    }

    @Transactional
    public void deleteById(Long id) {
        quizAnswerDao.deleteById(id);
    }

    @Transactional
    public void deleteQuizAnswerByQuestionId(Long id) {
        quizAnswerDao.deleteById(id);
    }

    @Transactional
    public QuizAnswer addQuizAnswer(QuizAnswerDto quizUserDto) {
        QuizAnswer quizAnswer;
        try {
            quizAnswer = QuizAnswerMapper.fromDto(quizUserDto, null);
        } catch (IOException e) {
            throw new AppException("Error with quiz answer image", HttpStatus.BAD_REQUEST);
        }

        return quizAnswerDao.save(quizAnswer);
    }

    @Transactional
    public void updateQuizAnswer(QuizAnswerDto quizUserDto, Long id) {
        quizAnswerDao.findById(id)
                .orElseThrow(() -> new AppException("Unknown quiz answer", HttpStatus.NOT_FOUND));
        QuizAnswer quizAnswer;
        try {
            quizAnswer = QuizAnswerMapper.fromDto(quizUserDto, id);
        } catch (IOException e) {
            throw new AppException("Error with quiz answer image", HttpStatus.BAD_REQUEST);
        }
        quizAnswerDao.save(quizAnswer);
    }


}
