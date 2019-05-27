package ru.hse.spb.keylogger.impl;

import org.springframework.stereotype.Service;
import ru.hse.spb.keylogger.UserService;

import javax.annotation.Nonnull;


@Service
public class UserServiceImpl implements UserService {
    @Override
    public String register(@Nonnull String login, @Nonnull String password) {
        return "lalala";
    }
}
