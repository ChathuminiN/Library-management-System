package dao.custom;


import java.util.ArrayList;
import dao.CrudDao;
import entity.MemberEntity;

public interface MemberDao extends CrudDao<MemberEntity, String> {


    boolean save(MemberEntity entity)throws Exception;

    boolean delete(String memID)throws Exception;

    MemberEntity get(String memID)throws Exception;

    boolean update(MemberEntity entity)throws Exception;

    ArrayList<MemberEntity> getAll()throws Exception;

    MemberEntity getN(String memName)throws Exception;

    
}
