package service;

import service.custom.impl.BookServiceImpl;
import service.custom.impl.CategoryServiceImpl;
import service.custom.impl.MemberServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    
    private ServiceFactory(){}
    
    public static ServiceFactory getInstance(){
        if(serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }
    
    public SuperService getService(ServiceType serviceType){
        switch (serviceType) {
            case CATEGORY:
                return new CategoryServiceImpl();
            case BOOK:
                return new BookServiceImpl();
<<<<<<< HEAD
            case MEMBER:
                return new MemberServiceImpl();
=======
            // case MEMBER:
            //     return new MemberServiceImpl();
>>>>>>> f977738b85816bdc630f829195bd91e74ef54928
            // case BORROWINGS:
            //     return new BorrowingServiceImpl();
            default:
                return null;
        }
        
    }
    
    public enum ServiceType{
        CATEGORY,BOOK,MEMBER,BORROWINGS;
    }
}
