package com.mysite.sbb.user;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SbbOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Autowired
    private UserRepository userRepository;

    private final DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws org.springframework.security.oauth2.core.OAuth2AuthenticationException {
        OAuth2User oAuth2User = delegate.loadUser(userRequest);
        
        // 구글 사용자 정보 추출
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String providerId = oAuth2User.getAttribute("sub"); // 구글 고유 ID
        
	    LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDate = now.format(formatDate);

        // 사용자 이메일로 User 엔티티가 존재하는지 확인하고, 없으면 새로 저장
        SiteUser user = userRepository.findByEmail(email);
        if (user == null) {
            user = new SiteUser();
            user.setEmail(email);
            user.setUsername(name);
            user.setCreateDt(formattedDate);
            user.setUseYn("Y");
            user.setProvider("google"); 
            user.setProviderId(providerId);
            userRepository.save(user);
        }

        return oAuth2User;
    }
}

