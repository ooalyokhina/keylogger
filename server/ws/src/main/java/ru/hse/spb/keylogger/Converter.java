package ru.hse.spb.keylogger;


import ru.hse.spb.keylogger.dto.ChangeDto;
import ru.hse.spb.keylogger.dto.ChangeTypeDto;
import ru.hse.spb.keylogger.dto.DiffDto;
import ru.hse.spb.keylogger.model.Change;
import ru.hse.spb.keylogger.model.ChangeType;
import ru.hse.spb.keylogger.model.Diff;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Converter {


    public static Diff toModel(final DiffDto diffDto, final Long userId) {
        return new Diff(toModel(diffDto.getChanges()),
                diffDto.getFileName(),
                diffDto.getProjectName(),
                diffDto.getTimestamp(),
                diffDto.getAction(),
                diffDto.getParams(),
                userId);
    }

    public static List<Change> toModel(final List<ChangeDto> changeDtos) {
        if (changeDtos == null) {
            return new ArrayList<>();
        }
        return changeDtos.stream().map(Converter::toModel).collect(Collectors.toList());
    }

    public static Change toModel(final ChangeDto changeDto) {
        return new Change(toModel(changeDto.getType()),
                changeDto.getPosition(),
                changeDto.getText());
    }

    public static ChangeType toModel(final ChangeTypeDto changeTypeDto) {
        return ChangeType.valueOf(changeTypeDto.name());
    }

}
