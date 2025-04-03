package com.devalvesg.my_rent.Application.UseCase;

import com.devalvesg.my_rent.Application.UseCase.Contracts.ICreateLessorUseCase;
import com.devalvesg.my_rent.Domain.Entities.LessorEntity;
import com.devalvesg.my_rent.Domain.Entities.UserEntity;
import com.devalvesg.my_rent.Domain.Exceptions.BusinessException;
import com.devalvesg.my_rent.Infrastructure.Repositories.Contract.ILessorRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateLessorUseCase implements ICreateLessorUseCase {

    private ILessorRepository lessorRepository;

    public CreateLessorUseCase(ILessorRepository lessorRepository) {
        this.lessorRepository = lessorRepository;
    }

    @Override
    public UserEntity createLessor(UserEntity user) throws BusinessException {
        if (lessorRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new BusinessException("Usuário já existe no banco de dados");
        }
        return lessorRepository.save(new LessorEntity(user));
    }
}
