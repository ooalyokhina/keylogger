package ru.hse.spb.keylogger.impl;

import org.springframework.stereotype.Service;
import ru.hse.spb.keylogger.UserRepository;
import ru.hse.spb.keylogger.UserService;
import ru.hse.spb.keylogger.dto.ResponseDto;
import ru.hse.spb.keylogger.dto.ResponseStatusDto;

import javax.annotation.Nonnull;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(@Nonnull final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseDto register(@Nonnull String login, @Nonnull String password) {
        final Optional<String> tokenOpt = userRepository.getToken(login);
        if (tokenOpt.isPresent()) {
            return new ResponseDto(ResponseStatusDto.WARNING,
                    "User with login " + login + " is exist",
                    tokenOpt.get());
        }
        final String token = userRepository.addUser(login, password);
        return new ResponseDto(ResponseStatusDto.OK, "", token);
    }
}
