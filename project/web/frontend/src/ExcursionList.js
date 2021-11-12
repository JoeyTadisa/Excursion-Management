import React, { useState } from "react";
import newExcursionEntry from "./NewExcursionEntry";

const excursionDataList = [
  {
    id: " 1",
    title: " Ulm",
    excursion_date: " 12.12.2021",
    description: " Fisherman Village",
    max_participants: " 25",
    reg_deadline: " 01.12.2021",
    dereg_deadline: " 25.11.2021",
    meeting_details: " Ulmer-Munster",
    destination: " Ulm",
  },
];

function ExcursionList() {
  const [excursions, setExcursions] = useState(excursionDataList);

  const addExcursionHandler = (excursion) => {
    console.log("In ExcursionList");
    console.log(excursion);
  };

  render();
  return (
    <div>
      <NewExcursionEntry onAddExcursion={addExcursionHandler} />
    </div>
  );
}

export default ExcursionList;
