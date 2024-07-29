package dao.custom;

<<<<<<< HEAD
import java.util.ArrayList;

=======
>>>>>>> f977738b85816bdc630f829195bd91e74ef54928
import dao.CrudDao;
import entity.MemberEntity;

public interface MemberDao extends CrudDao<MemberEntity, String> {
<<<<<<< HEAD

    boolean save(MemberEntity entity)throws Exception;

    boolean delete(String memID)throws Exception;

    MemberEntity get(String memID)throws Exception;

    boolean update(MemberEntity entity)throws Exception;

    ArrayList<MemberEntity> getAll()throws Exception;

    MemberEntity getN(String memName)throws Exception;
=======
>>>>>>> f977738b85816bdc630f829195bd91e74ef54928
    
}
