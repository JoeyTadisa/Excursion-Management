import React, { useEffect } from "react";
import { useHistory } from "react-router-dom";
import ExcursionForm from "../components/Excursions/ExcursionForm";
import useHttp from "../hooks/use-http";
import { addExcursion } from "../lib/api";

/**
 * @component NewExcursion
 * @param {function} props
 *
 */
const NewExcursion = (props) => {
  const { sendRequest, status } = useHttp(addExcursion);
  const history = useHistory();
  /**
   * user will be notified if the excursion has been added by displaying a message
   * and return to the excursion list view using useHistory hook
   */
  useEffect(() => {
    if (status === "completed") {
      alert("✨ The excursion was added and pending for approval ✨");
      history.push("/login/excursions");
    }
  }, [status, history]);
  /**
   * the new excursion data from ExcursionForm will be passed to this component and sent to backend
   * @param {Object} excursion
   */
  const onAddExcursionHandler = (excursion) => {
    sendRequest(excursion);
  };

  return (
    /**  once the excursionForm is submitted, the form is closed
     * and the new excursion data is passed back to this component,
     * to onAddExcursionHandler function to send the data to the backend
     */
    <div className="new-excursion-entry">
      <ExcursionForm
        isLoading={status === "pending"}
        onAddExcursion={onAddExcursionHandler}
      />
    </div>
  );
};

export default NewExcursion;
