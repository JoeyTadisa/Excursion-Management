import React from "react";
import ExcursionDetailedItem from "./ExcursionDetailedItem";
import "./ExcursionsDetailedList.css";

const ExcursionsDetailedList = (props) => {
  return (
    <ul className={"excursions-detailed-list"}>
      {props.items.map((excursion) => (
        <ExcursionDetailedItem
          key={excursion.id}
          title={excursion.title}
          //excursion_date={excursion.excursion_date}
          description={excursion.description}
          max_participants={excursion.max_participants}
          reg_deadline={excursion.reg_deadline}
          dereg_deadline={excursion.dereg_deadline}
          meeting_details={excursion.meeting_details}
        />
      ))}
    </ul>
  );
};

export default ExcursionsDetailedList;
