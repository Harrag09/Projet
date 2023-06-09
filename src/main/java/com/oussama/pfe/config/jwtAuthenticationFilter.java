package com.oussama.pfe.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class jwtAuthenticationFilter extends OncePerRequestFilter {
    private final jwtService jwtService;
    private final UserDetailsService userDetailService;
    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain) throws ServletException, IOException {
          final String authHeader =request.getHeader("Authorization");
          final String jwt;
          final String userEmail;

          if (authHeader == null||!authHeader.startsWith(("Bearer "))){
              filterChain.doFilter(request,response);
              return;
          }
          jwt = authHeader.substring(7);
          userEmail = jwtService.extractUsername(jwt);
          if(userEmail!=null && SecurityContextHolder.getContext().getAuthentication()== null)
          {
              UserDetails userDetails = this.userDetailService.loadUserByUsername(userEmail);

              if(jwtService.IsTokenValid(jwt, userDetails))
              {
                  UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                          userDetails,
                          null,
                          userDetails.getAuthorities()
                  );
                authToken.setDetails(
                        //yomekn andi moshkla hnee
                        new WebAuthenticationDetailsSource().buildDetails((jakarta.servlet.http.HttpServletRequest) request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
              }
          }
          filterChain.doFilter(request,response);
    }


}
