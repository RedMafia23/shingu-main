package com.shingu.shingubackend;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

public class AppConfig {
  // @Value("${jwt.public.key}")
  // RSAPublicKey key;

  // @Value("${jwt.private.key}")
  // RSAPrivateKey priv;

  // @Bean
  // DataSource dataSource() {
  // return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
  // .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION).build();
  // }

  // @Bean
  // UserDetailsManager users(DataSource dataSource) {
  // UserDetails user = User.builder()
  // .username("user")
  // .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
  // .roles("USER")
  // .build();
  // var users = new JdbcUserDetailsManager(dataSource);
  // users.createUser(user);
  // return users;
  // }

  // @Bean
  // SecurityFilterChain web(HttpSecurity http) throws Exception {
  // http.authorizeRequests(authorize -> authorize
  // .mvcMatchers("/products").permitAll()
  // .anyRequest().authenticated())
  // .cors()
  // .and()
  // .csrf(csrf -> csrf.ignoringAntMatchers("/**"))
  // .httpBasic(Customizer.withDefaults())
  // // ↓↓↓ ここから追加 ↓↓↓
  // .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
  // // ↑↑↑ ここまで追加 ↑↑↑
  // .sessionManagement(session ->
  // session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
  // return http.build();
  // }

  // @Bean
  // CorsConfigurationSource corsConfigurationSource() {
  // CorsConfiguration configuration = new CorsConfiguration();
  // configuration.setAllowedOrigins(Arrays.asList("https://shingu-main.github.io"));
  // configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT",
  // "DELETE"));
  // configuration.setAllowedHeaders(Arrays.asList("authorization",
  // "content-type"));
  // UrlBasedCorsConfigurationSource source = new
  // UrlBasedCorsConfigurationSource();
  // source.registerCorsConfiguration("/**", configuration);
  // return source;
  // }

  // @Bean
  // JwtEncoder jwtEncoder() {
  // JWK jwk = new RSAKey.Builder(key).privateKey(priv).build();
  // JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
  // return new NimbusJwtEncoder(jwks);
  // }

  // @Bean
  // JwtDecoder jwtDecoder() {
  // return NimbusJwtDecoder.withPublicKey(key).build();
  // }

  // @Bean
  // PasswordEncoder passwordEncoder() {
  // return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  // }
}
