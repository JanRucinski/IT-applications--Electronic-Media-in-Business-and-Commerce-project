import ContactForm from '@/components/contact/ContactForm';
import ContactInformation from '@/components/contact/ContactInformation';

const ContactPage = () => {
  return (
    <section className="container flex-1 md:flex justify-between items-center">
      <div className="w-2/4">
        <ContactInformation />
      </div>
      <div>
        <ContactForm />
      </div>
    </section>
  );
};

export default ContactPage;
