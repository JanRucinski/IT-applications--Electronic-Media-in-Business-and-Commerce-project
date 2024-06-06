import {
  Accordion,
  AccordionContent,
  AccordionItem,
  AccordionTrigger,
} from '@/components/ui/accordion';
import { aboutSection } from '@/config/content';

const Faq = () => {
  return (
    <Accordion type="single" collapsible className="w-full" id="faq">
      {aboutSection.faq.map((item, index) => {
        return (
          <AccordionItem
            key={item.question}
            value={item.question}
            id={`accordion-item-${index}`}
          >
            <AccordionTrigger className="text-start">
              {item.question}
            </AccordionTrigger>
            <AccordionContent>{item.answer}</AccordionContent>
          </AccordionItem>
        );
      })}
    </Accordion>
  );
};

export default Faq;
