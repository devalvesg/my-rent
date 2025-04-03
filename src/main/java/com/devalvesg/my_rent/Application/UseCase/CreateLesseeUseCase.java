package com.devalvesg.my_rent.Application.UseCase;

import com.devalvesg.my_rent.Application.UseCase.Contracts.ICreateLesseeUseCase;
import com.devalvesg.my_rent.Domain.Entities.LesseeEntity;
import com.devalvesg.my_rent.Domain.Entities.UserEntity;
import com.devalvesg.my_rent.Domain.Exceptions.BusinessException;
import com.devalvesg.my_rent.Infrastructure.Repositories.Contract.ILesseeRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateLesseeUseCase implements ICreateLesseeUseCase {

    private ILesseeRepository lesseeRepository;

    public CreateLesseeUseCase(ILesseeRepository lesseeRepository){
        this.lesseeRepository = lesseeRepository;
    }

    @Override
    public UserEntity createLessee(UserEntity user) throws BusinessException {
        lesseeRepository.findByEmail(user.getEmail()).orElseThrow(() -> new BusinessException("Usuário já existe no banco de dados"));
        return lesseeRepository.save(new LesseeEntity(user));
    }
}
