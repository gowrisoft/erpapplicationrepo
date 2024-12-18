package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.DependantsDto;
import com.gentech.erp.hr.entity.Dependants;
import com.gentech.erp.hr.mapper.DependantsMapper;
import com.gentech.erp.hr.repository.DependantsRepository;
import com.gentech.erp.hr.service.DependantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DependantServiceImpl implements DependantService {

    @Autowired
    private DependantsRepository repo;

    @Override
    public DependantsDto saveDependant(DependantsDto dep) {
        Dependants obj = DependantsMapper.DtoToObject(dep);
        repo.save(obj);
        dep=DependantsMapper.ObjectToDto(obj);
        return dep;
    }

    @Override
    public List<DependantsDto> getAllDependant() {
        List<Dependants> obj=repo.findAll();
        List<DependantsDto> menuDto= new ArrayList<>();
        for(int i=0;i<obj.size();i++)
        {
            menuDto.add(DependantsMapper.ObjectToDto(obj.get(i)));
        }
        return menuDto;
    }

    @Override
    public DependantsDto getDependantById(Long dependantId) throws Exception  {
        Optional<Dependants> obj= repo.findById(dependantId);
        if(obj.isPresent())
        {
            DependantsDto dto = DependantsMapper.ObjectToDto(obj.get());
            return dto;

        }
        throw new Exception("The item is not present");
    }


    @Override
    public DependantsDto updateItem(DependantsDto upd, Long id)  throws Exception{
        Optional<Dependants> obj=repo.findById(id);
        if(obj.isPresent())
        {
            Dependants n = obj.get();
            n.setDependantId(upd.getDependantId());
            n.setDependantAge(upd.getDependantAge());
            n.setDependantName(upd.getDependantName());

            repo.save(n);
            upd=DependantsMapper.ObjectToDto(n);
            return upd;
        }
        throw new Exception("The item is not present");
    }

    @Override
    public void deleteItemById(Long id) {
        repo.deleteById(id);

    }
}
