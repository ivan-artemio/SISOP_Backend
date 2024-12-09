package com.sisop.hexagonal.users.application.find;

import com.sisop.hexagonal.users.domain.model.UserQuery;
import com.sisop.hexagonal.users.domain.repository.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFindUseCase {

    private final UserQueryRepository userQueryRepository;

    public UserQuery findById(Long id){
        return this.userQueryRepository.findById(id).orElseThrow();
    }
    public List<UserQuery> findAll(){
        return this.userQueryRepository.findAll();
    }

    public UserQuery findByEmail(String email){
        return this.userQueryRepository.searchByEmail(email);
    }

}
