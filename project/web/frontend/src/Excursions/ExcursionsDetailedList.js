import React from "react";
import ExcursionDetailedItem from "./ExcursionDetailedItem";
import "./ExcursionsDetailedList.css";
import Card from "../UI/Card";

const ExcursionsDetailedList = (props) => {
  return (
    <ul className={"excursions-detailed-list"}>
      {props.items.map((excursion) => (
        <div className="excursions-detailed-list-list">
          <ExcursionDetailedItem
            key={excursion.id}
            title={excursion.title}
            date_of_excursion={excursion.date_of_excursion}
            excursion_fee={excursion.excursion_fee}
            description={excursion.description}
            max_participants={excursion.max_participants}
            reg_deadline={excursion.reg_deadline}
            dereg_deadline={excursion.dereg_deadline}
            meeting_details={excursion.meeting_details}
          />
        </div>
      ))}
    </ul>
  );
};

export default ExcursionsDetailedList;
