import React from "react";
import ExcursionForm from "./Excursions/ExcursionForm";

const newExcursionEntry = (props) => {
  const saveExcursionDataHandler = (enteredExcursionData) => {
    const excursionData = {
      ...enteredExcursionData,
      id: Math.random().toString(),
    };
    console.log(excursionData);
    props.onAddExcursion(excursionData);
  };

  return (
    // once the excursionForm is submitted, new excursionData 
    // the form is closed and the new excursion data is passed to 
    <div className="new-excursion-entry">
      <ExcursionForm
        onSaveExcursionData={saveExcursionDataHandler}
        onBackToExcursionView={props.onBackToExcursionView}
      />
    </div>
  );
};

export default newExcursionEntry;
