package service.custom;

<<<<<<< HEAD
import java.util.ArrayList;
import dto.MemberDto;
import service.SuperService;

public interface MemberService extends SuperService {

    String save(MemberDto memberDto)throws Exception;

    String delete(String memID)throws Exception;

    MemberDto get(String memID)throws Exception;

    MemberDto getN(String memName)throws Exception;

    ArrayList<MemberDto> getAll()throws Exception;

    String update(MemberDto memberDto)throws Exception;

    
=======
import service.SuperService;

public interface MemberService extends SuperService {
>>>>>>> f977738b85816bdc630f829195bd91e74ef54928
    
}
