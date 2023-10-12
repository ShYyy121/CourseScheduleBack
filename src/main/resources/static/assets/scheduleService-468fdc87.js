import{a as e}from"./axios-4a70c6fc.js";async function a(o){try{return(await e.get(`/api/schedule/search/findByClassroom?id=${o}`)).data}catch(r){throw console.error(r),r}}export{a as g};
