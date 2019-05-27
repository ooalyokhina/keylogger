package ru.hse.spb.keylogger.impl;

import org.springframework.stereotype.Service;
import ru.hse.spb.keylogger.Converter;
import ru.hse.spb.keylogger.UserRepository;
import ru.hse.spb.keylogger.UserService;
import ru.hse.spb.keylogger.WorklogRepository;
import ru.hse.spb.keylogger.WorklogService;
import ru.hse.spb.keylogger.dto.DiffDto;
import ru.hse.spb.keylogger.dto.ResponseDto;
import ru.hse.spb.keylogger.dto.ResponseStatusDto;
import ru.hse.spb.keylogger.model.Diff;

import javax.annotation.Nonnull;
import java.util.Optional;

@Service
public class WorklogServiceImpl implements WorklogService {
    private final UserRepository userRepository;
    private final WorklogRepository worklogRepository;

    public WorklogServiceImpl(@Nonnull final UserRepository userRepository,
                              @Nonnull final WorklogRepository worklogRepository) {
        this.userRepository = userRepository;
        this.worklogRepository = worklogRepository;
    }


    @Override
    public ResponseDto register(DiffDto diffDto, @Nonnull String token) {
        final Optional<Long> userId = userRepository.getIdByToken(token);
        if (!userId.isPresent()) {
            return new ResponseDto(ResponseStatusDto.ERROR, "User not found", "");
        }
        final Diff diff = Converter.toModel(diffDto, userId.get());
        final Long wlId = worklogRepository.addDiff(diff);
        return new ResponseDto(ResponseStatusDto.OK, "", wlId.toString());
    }
}
