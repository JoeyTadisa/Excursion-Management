const FIREBASE_DOMAIN = "https://react-prep-default-rtdb.firebaseio.com";

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

export async function getExcursionById(excursionId) {
  const response = await fetch(
    `${FIREBASE_DOMAIN}/excursions/${excursionId}.json`
  );
  const data = await response.json();

  if (!response.ok) {
    throw new Error(data.message || "Could not fetch excursion.");
  }

  const loadedExcursion = {
    id: excursionId,
    ...data,
  };

  return loadedExcursion;
}

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
