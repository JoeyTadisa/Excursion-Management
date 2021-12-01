import React from "react";
import ExcursionForm from "./Excursions/ExcursionForm";

const NewExcursionEntry = (props) => {
  // newly created excursion is sent and saved in backend
  async function saveExcursionDataHandler(excursion) {
    const response = await fetch("http://localhost:9191/addExcursion", {
      method: "POST",
      body: JSON.stringify(excursion),
      headers: {
        "Content-Type": "application/json",
      },
    });
    const data = await response.json();
    console.log(data);
  }

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

export default NewExcursionEntry;
