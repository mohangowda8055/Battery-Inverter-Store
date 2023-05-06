package com.bgv.battery.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bgv.battery.model.TwoVModel;

@Repository
public interface TwoVModelRepo extends JpaRepository<TwoVModel, Integer> {

	@Query(value="SELECT * FROM two_v_model t WHERE t.brand_id=:brandId", nativeQuery=true)
	List<TwoVModel> findByBrandId(Integer brandId);
}
