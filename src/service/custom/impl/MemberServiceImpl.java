package service.custom.impl;


import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.MemberDao;
import dto.MemberDto;
import entity.MemberEntity;
import service.custom.MemberService;

public class MemberServiceImpl implements MemberService {
    private MemberDao memberDao = (MemberDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.MEMBER);

    @Override
    public String save(MemberDto memberDto) throws Exception {
        MemberEntity entity = getEntity(memberDto);
        return memberDao.save(entity) ? "Success" : "Fail";
    }

    private MemberEntity getEntity(MemberDto memberDto) {
        return  new MemberEntity(
            memberDto.getMemberID(),
            memberDto.getMemberName(),
            memberDto.getDob(),
            memberDto.getAdrress(),
            memberDto.getContact (),
            memberDto.getEmail()
            );
    }

    @Override
    public String delete(String memID) throws Exception {
        return memberDao.delete(memID) ? "Success" : "Fail";
    }

    @Override
    public MemberDto get(String memID) throws Exception {
        MemberEntity entity = memberDao.get(memID);
        if(entity != null){
            return getDto(entity);
        }
        return null;
    }

    private MemberDto getDto(MemberEntity entity) {
        return  new MemberDto(
            entity.getMemberID(),
            entity.getMemberName(), 
            entity.getDob(), 
            entity.getAdrress(),
            entity.getContact(), 
            entity.getEmail()  
            );
    }

    @Override
    public MemberDto getN(String memName) throws Exception {
        MemberEntity entity = memberDao.getN(memName);
        if(entity != null){
            return getDto(entity);
        }
        return null;
    }

    @Override
    public ArrayList<MemberDto> getAll() throws Exception {
        ArrayList<MemberEntity> Entities = memberDao.getAll();
        if(Entities != null && !Entities.isEmpty()){
            ArrayList<MemberDto> memberDtos = new ArrayList<>();
            
            for (MemberEntity entity : Entities) {
                memberDtos.add(getDto(entity));
            }
            
            return memberDtos;
        }
        return null;
    }

    @Override
    public String update(MemberDto memberDto) throws Exception {
        MemberEntity entity = getEntity(memberDto);
        return memberDao.update(entity) ? "Success" : "Fail";
    }
}
