package repository;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import config.global.DatabaseConfig;
import config.global.PropertyConfig;
import model.Articulo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class, PropertyConfig.class })
public class ArticuloRepositoryTest {
	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Test
	@Transactional
	public void agregar() {
		Articulo a = new Articulo("nuevo", "nuevo", new Date());
		articuloRepository.save(a);
		Assert.assertNotNull(a.getId());
	}
}



