import { MapPin, Phone, Mail, LucideIcon, CalendarDays } from 'lucide-react';

type ContactItemProps = {
  Icon: LucideIcon;
  title: string;
  children: React.ReactNode;
};

const ContactItem = ({ Icon, title, children }: ContactItemProps) => {
  return (
    <div className="flex gap-5 items-center border rounded-lg shadow-sm p-4 bg-background">
      <Icon className="text-primary w-5 h-5 md:w-7 md:h-7" />
      <div>
        <h3 className="font-medium text-base md:text-lg">{title}</h3>
        {children}
      </div>
    </div>
  );
};

const ContactInformation = () => {
  return (
    <div>
      <h1 className="text-xl text-center md:text-3xl font-semibold text-gray-800 mb-6 md:mb-10">
        Contact Information
      </h1>
      <div className="space-y-4">
        <ContactItem Icon={MapPin} title="Visit us">
          <address>123 Street 256 House</address>
        </ContactItem>
        <ContactItem Icon={Phone} title="Call us">
          +123 456 7890
        </ContactItem>
        <ContactItem Icon={Mail} title="Email us">
          <a href="mailto:support@bikeshop.com">support@bikeshop.com</a>
        </ContactItem>
        <ContactItem Icon={CalendarDays} title="Working hours">
          <p>Mon - Fri: 9:00 - 19:00</p>
        </ContactItem>
      </div>
    </div>
  );
};

export default ContactInformation;
