import { Contact } from "./models/contact";

function displayContactDetails(contact: Contact): void {
    (document.getElementById('detail-name') as HTMLSpanElement).textContent = contact.firstname;
    (document.getElementById('detail-email') as HTMLSpanElement).textContent = contact.email;
    (document.getElementById('detail-phone') as HTMLSpanElement).textContent = contact.phone;
}

function attachClickEvent(li: HTMLLIElement): void {
    li.addEventListener('click', () => {
        const contact: Contact = {
            firstname: li.dataset.name || '',
            email: li.dataset.email || '',
            phone: li.dataset.phone || ''
        };
        displayContactDetails(contact);
    });
}

// Ajout des événements pour les contacts existants
document.querySelectorAll('.contact-item').forEach(item => {
    attachClickEvent(item as HTMLLIElement);
});

// Gérer l'ajout d'un contact
const form = document.getElementById('contact-form') as HTMLFormElement;

form.addEventListener('submit', (e: Event) => {
    e.preventDefault();

    const fisrtnameInput = document.getElementById('name') as HTMLInputElement;
    const lastnameInput = document.getElementById('name') as HTMLInputElement;
    const birthdateInput = document.getElementById("birthdate") as HTMLInputElement;
    const emailInput = document.getElementById('email') as HTMLInputElement;
    const phoneInput = document.getElementById('phone') as HTMLInputElement;
    const avatarInput = document.getElementById('avatar') as HTMLInputElement;

    const contact: Contact = {
        firstname: fisrtnameInput.value.trim(),
        lastname: lastnameInput.value.trim(),
        birthdate: birthdateInput.value.trim(),
        email: emailInput.value.trim(),
        phone: phoneInput.value.trim(),
        avatarUrl: avatarInput.value.trim()
    };

    if (!contact.firstname || !contact.lastname || !contact.birthdate || !contact.email || !contact.phone || !contact.avatarUrl) return;

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

    const list = document.getElementById('contact-list') as HTMLUListElement;
    list.appendChild(li);

    // Réinitialiser formulaire
    form.reset();

    // Fermer le modal
    const modalElement = document.getElementById('addContactModal') as HTMLElement;
    const modal = bootstrap.Modal.getInstance(modalElement);
    modal?.hide();
});
