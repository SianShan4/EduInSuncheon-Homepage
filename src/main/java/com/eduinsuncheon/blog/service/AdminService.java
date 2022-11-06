package com.eduinsuncheon.blog.service;

import com.eduinsuncheon.blog.model.Board;
import com.eduinsuncheon.blog.model.User;
import com.eduinsuncheon.blog.repository.BoardRepository;
import com.eduinsuncheon.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<User> findAllUser() {
        return userRepository.findAll();
    }


    @Transactional(readOnly = true)
    public User findUserById(int id) {
        return userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("유저 찾기 실패 : 아이디를 찾을 수 없습니다.");
        });
    }


    @Transactional(readOnly = true)
    public List<Board> findAllBoardByUser(User user) {
        return boardRepository.findAllByUserOrderByIdDesc(user);
    }


    @Transactional
    public void changeRole(int userId, User roleUser) {
        User resultUser = userRepository.findById(userId).orElseThrow(()->{
            return new IllegalArgumentException("회원 찾기 실패");
        });

        resultUser.setRole(roleUser.getRole());
    }


    // 토탈 조회수 구하기
    @Transactional
    public int getTotalViewCount() {
        int count = 0;
        List<Board> allBoard = boardRepository.findAll();
        for(Board board : allBoard) {
            count += board.getViews();
        }
        return count;
    }


    // 전체 회원 수 구하기
    @Transactional
    public int getTotalUsersCount() {
        int count = 0;
        List<User> allUsers = userRepository.findAll();
        for(User user : allUsers) {
            count += 1;
        }
        return count;
    }



}