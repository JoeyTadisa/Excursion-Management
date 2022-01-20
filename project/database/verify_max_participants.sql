SELECT * FROM thu_excursion_v6.student_booking_excursion;

-- return: id_excursion, max_participants, 

SELECT id_excursion,max_participants FROM thu_excursion_v6.student_booking_excursion;


SELECT id_excursion,booked_by, max_participants FROM thu_excursion_v6.student_booking_excursion;

USE thu_excursion_v6;
SELECT rs2.id_excursion, rs2.bookings, rs2.max_participants, rs2.places_available, 
	CASE 
		WHEN rs2.places_available > 0 THEN TRUE
        WHEN rs2.places_available = 0 THEN FALSE
        ELSE FALSE
	END AS is_booking_allowed
FROM	(SELECT rs1.id_excursion, rs1.bookings, rs1.max_participants, (max_participants - bookings) as places_available
		FROM	(SELECT id_excursion,COUNT(booked_by) as bookings, max_participants
				FROM student_booking_excursion
				GROUP BY id_excursion) as rs1) as rs2
