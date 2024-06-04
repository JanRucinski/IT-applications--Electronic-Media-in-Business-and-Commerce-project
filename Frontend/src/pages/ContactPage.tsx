import ContactForm from '@/components/contact/ContactForm';
import ContactInformation from '@/components/contact/ContactInformation';

const ContactPage = () => {
  return (
    <section className="container flex-1 flex flex-col md:flex-row justify-between items-center gap-10">
      <div className="md:w-2/4">
        <ContactInformation />
      </div>
      <div>
        <ContactForm />
      </div>
    </section>
  );
};

export default ContactPage;
