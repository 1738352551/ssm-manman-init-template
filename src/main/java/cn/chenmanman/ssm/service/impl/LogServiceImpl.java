package cn.chenmanman.ssm.service.impl;

import cn.chenmanman.ssm.exception.BusinessException;
import cn.chenmanman.ssm.mapper.LogMapper;
import cn.chenmanman.ssm.model.entity.Log;
import cn.chenmanman.ssm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;
    @Override
    public int addLog(Log log) {
        if (Objects.isNull(log)) {
            throw new BusinessException(500, "log不能为空");
        }
        return logMapper.insertLog(log);
    }
}
