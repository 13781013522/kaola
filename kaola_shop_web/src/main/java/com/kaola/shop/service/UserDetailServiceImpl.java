package com.kaola.shop.service;

import com.kaola.pojo.TbSeller;
import com.kaola.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailServiceImpl implements UserDetailsService {

    private SellerService sellerService;


    public SellerService getSellerService() {
        return sellerService;
    }

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));//分配的角色
        //根据用户名查询用户信息
        TbSeller seller = sellerService.findOne(username);//查询出用户信息
        if(seller != null){
            if (seller.getStatus().equals("1")){//判断审核通过
                return new User(username,seller.getPassword(),grantedAuthorities);
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
}
