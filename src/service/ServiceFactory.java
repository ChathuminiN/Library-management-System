package service;

import service.custom.impl.CategoryServiceImpl;

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
            // case CUSTOMER:
            //     return new CustomerServiceimpl();
            // case ORDER:
            //     return new OrderServiceImpl();
            default:
                return null;
        }
        
    }
    
    public enum ServiceType{
        CATEGORY;
    }
}