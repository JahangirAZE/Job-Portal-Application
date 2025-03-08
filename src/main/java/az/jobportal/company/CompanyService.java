package az.jobportal.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
    boolean updateCompany(Long id, Company updatedCompany);
    void createCompany(Company Company);
    boolean deleteCompany(Long id);
}