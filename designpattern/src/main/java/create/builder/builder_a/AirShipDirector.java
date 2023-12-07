/**  
 * @author ronin
 * @date 2019年3月23日  
 * @version V1.0  
 */ 
package create.builder.builder_a;

/**  
 * 装配AirShip
 * @author ronin  
 * @date 2019年3月23日  
 *    
 */
public class AirShipDirector {

	private AbstractAirShipBuilder airShipBuilder;

	public AirShipDirector(AbstractAirShipBuilder airShipBuilder) {
		this.airShipBuilder = airShipBuilder;
	}

	public void setAirShipBuilder(AbstractAirShipBuilder airShipBuilder) {
		this.airShipBuilder = airShipBuilder;
	}

	public AirShip directAirShip() {
		//装配飞船逻辑步骤
		airShipBuilder.buildOrbitalModule();
		airShipBuilder.buildEngin();
		airShipBuilder.buildEscapeTower();
		return airShipBuilder.buildAirShip();
	}

}
