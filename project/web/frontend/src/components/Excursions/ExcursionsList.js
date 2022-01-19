import React from "react";
import ExcursionItem from "./ExcursionItem";
import "./ExcursionsList.css";
/**
 * displays the list of excursions with only the title and date of excursion
 * @component ExcursionsList
 * @param {Array<Object>} props excursions data
 */
const ExcursionsList = (props) => {
  // if no excursions in the filtered year, a msg displayed
  if (props.items.length === 0) {
    return <h2 className="excursions-list__fallback">Found no excursions.</h2>;
  }

  // if there are items in the filtered year, display all excursions of that year
  return (
    <ul className="excursions-list">
      {props.items.map((excursion) => (
        <ExcursionItem
          key={excursion.id}
          id={excursion.id}
          title={excursion.title}
          date={excursion.date_of_excursion}
        />
      ))}
    </ul>
  );
};

export default ExcursionsList;
