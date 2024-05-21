import {
  Accordion,
  AccordionContent,
  AccordionItem,
  AccordionTrigger,
} from '@/components/ui/accordion';
import { aboutSection } from '@/config/content';

const Faq = () => {
  return (
    <Accordion type="single" collapsible className="w-full">
      {aboutSection.map((item) => {
        return (
          <AccordionItem key={item.question} value={item.question}>
            <AccordionTrigger>{item.question}</AccordionTrigger>
            <AccordionContent>{item.answer}</AccordionContent>
          </AccordionItem>
        );
      })}
    </Accordion>
  );
};

export default Faq;
