package org.mylife.rest;

import org.mylife.Data;
import org.mylife.Position;
import org.mylife.VehicleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Eureka calls the microservice client, here its Eureka's client
 * @author vimal
 *
 */
@RestController
public class PositionReportsController 
{
	@Autowired
	private Data data;
	// REST end point, that returns latest position
	@RequestMapping(method=RequestMethod.GET,value="/vehicles/{vehicleName}")
	public ResponseEntity<Position> getLatestReportForVehicle(@PathVariable String vehicleName)
	{
		try 
		{
			Position position = data.getLatestPositionFor(vehicleName);
			return new ResponseEntity<Position>(position, HttpStatus.OK);
		} 
		catch (VehicleNotFoundException e) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
