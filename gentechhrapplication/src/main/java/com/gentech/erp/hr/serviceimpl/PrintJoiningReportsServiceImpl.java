package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.PrintJoiningReportsDto;
import com.gentech.erp.hr.entity.PrintJoiningReports;
import com.gentech.erp.hr.mapper.PrintJoiningReportsMapper;
import com.gentech.erp.hr.repository.PrintJoiningReportsRepository;
import com.gentech.erp.hr.service.PrintJoiningReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrintJoiningReportsServiceImpl implements PrintJoiningReportsService {

    @Autowired
    private PrintJoiningReportsRepository printRepo;

    @Override
    public PrintJoiningReportsDto createPrintReports(PrintJoiningReportsDto printDto) {
        PrintJoiningReports printJoiningReports = PrintJoiningReportsMapper.mapPrintJoinDtoToPrintJoin(printDto);
        printRepo.save(printJoiningReports);
        return PrintJoiningReportsMapper.mapPrintJoinToPrintJoinDto(printJoiningReports);
    }

    @Override
    public List<PrintJoiningReportsDto> getAllPrintReportss() {
        return printRepo.findAll()
                .stream().map((printJoining) -> PrintJoiningReportsMapper.mapPrintJoinToPrintJoinDto(printJoining))
                .toList();
    }

}
