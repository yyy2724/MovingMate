package com.example.MovingMate.service.company;

import com.example.MovingMate.constrant.Role;
import com.example.MovingMate.dto.company.CompanyDto;
import com.example.MovingMate.dto.company.MailHandler;
import com.example.MovingMate.entity.company.CompanyEntity;
import com.example.MovingMate.repository.company.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    private final JavaMailSender javaMailSender;
    private final JavaMailSenderImpl javaMailSenderImpl;

    private final PasswordEncoder passwordEncoder;

    public void mailSend(HttpSession session, String email) {
        try {
            MailHandler mailHandler = new MailHandler(javaMailSenderImpl);
            Random random = new Random(System.currentTimeMillis());
            Long start = System.currentTimeMillis();

            int result = 100000 + random.nextInt(900000);

            // 받는분
            mailHandler.setTo(email);
            // 보내는 사람
            mailHandler.setFrom("yyy042352@gmail.com");
            // 제목
            mailHandler.setSubject("인증번호입니다.");

            String htmlContent = "<html>" +
                    "<head>" +
                    "<style>" +
                    "body {" +
                    "    font-family: Arial, sans-serif;" +
                    "    text-align: center;" +
                    "}" +
                    ".container {" +
                    "    background-color: #f2f2f2;" +
                    "    border-radius: 10px;" +
                    "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);" +
                    "    margin: 20px auto;" +
                    "    max-width: 400px;" +
                    "    padding: 20px;" +
                    "}" +
                    "h1 {" +
                    "    color: #007bff;" +
                    "    font-size: 24px;" +
                    "}" +
                    "p {" +
                    "    font-size: 16px;" +
                    "    line-height: 1.6;" +
                    "}" +
                    ".verification-code {" +
                    "    background-color: #007bff;" +
                    "    border-radius: 5px;" +
                    "    color: #ffffff;" +
                    "    display: inline-block;" +
                    "    font-size: 20px;" +
                    "    padding: 10px 20px;" +
                    "}" +
                    "</style>" +
                    "</head>" +
                    "<body>" +
                    "<div class='container'>" +
                    "  <h1>안녕하세요.</h1>" +
                    "  <h1>TechForge의 인증코드를 발송합니다</h1>" +
                    "  <br>" +
                    "  <p>아래 코드를 창으로 돌아가 입력해주세요.</p>" +
                    "  <br>" +
                    "  <div align='center'>" +
                    "    <h3>회원가입 인증 코드입니다.</h3>" +
                    "    <div class='verification-code'>" + result + "</div>" +
                    "  </div>" +
                    "  <br/>" +
                    "</div>" +
                    "</body>" +
                    "</html>";
            mailHandler.setText(htmlContent, true);
            mailHandler.send();

            Long end = System.currentTimeMillis();
            session.setAttribute("" + email, result);
            System.out.println("실행시간: " + (end - start) / 1000.0);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public int emailCheck(String email) {
        int memberRs = companyRepository.findByEmail1(email);
        return memberRs;
    }

    public Long companyJoin(CompanyDto companyDto) {

        CompanyEntity companyEntity = CompanyEntity.builder()
                .id(companyDto.getId())
                .companyName(companyDto.getCompanyName())
                .role(Role.valueOf("COMPANY"))
                .phone(companyDto.getPhone())
                .businessNumber(companyDto.getBusinessNumber())
                .postcode(companyDto.getPostcode())
                .address(companyDto.getAddress())
                .detailAddress(companyDto.getDetailAddress())
                .extraAddress(companyDto.getExtraAddress())
                .email(companyDto.getEmail())
                .password(passwordEncoder.encode(companyDto.getPassword()))
                .build();

        return companyRepository.save(companyEntity).getId();
    }

    public int businessNumberCheck(String businessNumber) {
        int rs = companyRepository.findByBusinessNumber(businessNumber);
        return rs;
    }

    public int companyNameCheck(String companyName) {
        int rs = companyRepository.findByCompanyName(companyName);
        return rs;
    }

    public int phoneNumberCheck(String phone) {
        int rs = companyRepository.findByPhone(phone);
        return rs;
    }

    public boolean emailCertification(HttpSession session, String email, int inputCode) {
        try {
            int generationCode = (int) session.getAttribute(email);
            if (generationCode == inputCode) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            throw e;
        }

//            if(generationCode == inputCode){
//                return true;
//            } else{
//                return false;
//            }
//        } catch (Exception e){
//            throw e;
//        }

    }
}



