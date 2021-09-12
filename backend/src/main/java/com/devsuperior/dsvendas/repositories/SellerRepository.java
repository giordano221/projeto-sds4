package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entitties.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>
{

}
