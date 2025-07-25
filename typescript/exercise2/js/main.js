function displayContactDetails(contact) {
    document.getElementById('detail-name').textContent = contact.firstname;
    document.getElementById('detail-email').textContent = contact.email;
    document.getElementById('detail-phone').textContent = contact.phone;
}
function attachClickEvent(li) {
    li.addEventListener('click', () => {
        const contact = {
            firstname: li.dataset.name || '',
            email: li.dataset.email || '',
            phone: li.dataset.phone || ''
        };
        displayContactDetails(contact);
    });
}
// Ajout des événements pour les contacts existants
document.querySelectorAll('.contact-item').forEach(item => {
    attachClickEvent(item);
});
// Gérer l'ajout d'un contact
const form = document.getElementById('contact-form');
form.addEventListener('submit', (e) => {
    e.preventDefault();
    const fisrtnameInput = document.getElementById('name');
    const lastnameInput = document.getElementById('name');
    const birthdateInput = document.getElementById("birthdate");
    const emailInput = document.getElementById('email');
    const phoneInput = document.getElementById('phone');
    const avatarInput = document.getElementById('avatar');
    const contact = {
        firstname: fisrtnameInput.value.trim(),
        lastname: lastnameInput.value.trim(),
        birthdate: birthdateInput.value.trim(),
        email: emailInput.value.trim(),
        phone: phoneInput.value.trim(),
        avatarUrl: avatarInput.value.trim()
    };
    if (!contact.firstname || !contact.lastname || !contact.birthdate || !contact.email || !contact.phone || !contact.avatarUrl)
        return;
    const li = document.createElement('li');
    li.className = 'list-group-item contact-item';
    li.textContent = contact.firstname;
    li.dataset.firstname = contact.firstname;
    li.dataset.lastname = contact.lastname;
    li.dataset.birthdate = contact.birthdate;
    li.dataset.email = contact.email;
    li.dataset.phone = contact.phone;
    li.dataset.avatarUrl = contact.avatarUrl;
    attachClickEvent(li);
    const list = document.getElementById('contact-list');
    list.appendChild(li);
    // Réinitialiser formulaire
    form.reset();
    // Fermer le modal
    const modalElement = document.getElementById('addContactModal');
    const modal = bootstrap.Modal.getInstance(modalElement);
    modal === null || modal === void 0 ? void 0 : modal.hide();
});
export {};
