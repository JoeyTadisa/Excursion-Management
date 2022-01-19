/**
 *
 * @module api
 */

export async function getAllExcursions() {
  const response = await fetch("http://localhost:9191/approvedExcursions/true");
  const data = await response.json();

  if (!response.ok) {
    throw new Error(data.message || "Could not fetch excursions.");
  }

  const transformedExcursions = [];

  for (const key in data) {
    const excursionObj = {
      id: key,
      title: key,
      date_of_excursion: new Date(key),
      excursion_fee: key,
      description: key,
      max_participants: key,
      destination: key,
      reg_deadline: new Date(key),
      dereg_deadline: new Date(key),
      meeting_details: key,
      ...data[key],
    };

    transformedExcursions.push(excursionObj);
  }

  return transformedExcursions;
}

export async function getAllNotApprovedExcursions() {
  const response = await fetch(
    "http://localhost:9191/approvedExcursions/false"
  );
  const data = await response.json();

  if (!response.ok) {
    throw new Error(data.message || "Could not fetch excursions.");
  }

  const transformedExcursions = [];

  for (const key in data) {
    const excursionObj = {
      id: key,
      title: key,
      date_of_excursion: new Date(key),
      excursion_fee: key,
      description: key,
      max_participants: key,
      destination: key,
      reg_deadline: new Date(key),
      dereg_deadline: new Date(key),
      meeting_details: key,
      ...data[key],
    };

    transformedExcursions.push(excursionObj);
  }

  return transformedExcursions;
}
/**
 * sending the excursion details to backend
 * @param {Object} excursion adding a new excursion
 * @returns {void}
 */
export async function addExcursion(excursion) {
  const response = await fetch(`http://localhost:9191/addExcursion`, {
    method: "POST",
    body: JSON.stringify(excursion),
    headers: {
      "Content-Type": "application/json",
    },
  });
  const data = await response.json();

  if (!response.ok) {
    throw new Error(data.message || "Could not create excursion.");
  }

  return null;
}

/**
 * sending the excursion details to backend
 * @param {Object} excursion updating an existing excursion
 */
export async function updateExcursion(excursion) {
  const response = await fetch(`http://localhost:9191/updateExcursion`, {
    method: "PUT",
    body: JSON.stringify(excursion),
    headers: {
      "Content-Type": "application/json",
    },
  });
  const data = await response.json();

  if (!response.ok) {
    throw new Error(data.message || "Could not update excursion.");
  }

  return null;
}
