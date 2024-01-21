package com.tech.map.model

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


enum class Role {
    USER,
    ADMIN
}


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
class User : UserDetails {
    @Id
    @GeneratedValue
    private val id: Int? = null

    private val username: String? = null
    private val password: String? = null

    @Enumerated(EnumType.STRING)
    private val role: Role? = null

    //@OneToMany(mappedBy = "user")
    //private val tokens: List<Token>? = null
    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return java.util.List.of(SimpleGrantedAuthority(role!!.name))
    }

    override fun getPassword(): String {
        return password!!
    }

    override fun getUsername(): String {
        return username!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}