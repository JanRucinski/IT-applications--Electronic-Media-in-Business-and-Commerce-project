import Faq from '@/components/about/FAQ';
import { aboutSection } from '@/config/content';

const AboutPage = () => {
  return (
    <section className="container flex-1 grid md:grid-cols-2 items-center justify-between gap-20 py-10">
      <div className="flex flex-col justify-between p-10 rounded-md shadow-lg">
        <div>
          <h1 className="text-center font-semibold text-3xl mb-4">
            Frequently Asked Questions
          </h1>
        </div>
        <Faq />
      </div>
      <div>
        <h1 className="text-center font-bold text-4xl mb-3">
          {aboutSection.title}
        </h1>
        <p className="text-lg leading-relaxed mb-6">
          {aboutSection.description}
        </p>
        <div className="h-72 rounded-md overflow-hidden shadow-lg border py-2">
          <img
            src={aboutSection.image}
            alt={aboutSection.imgAlt}
            className="w-full h-full object-cover"
          />
        </div>
      </div>
    </section>
  );
};

export default AboutPage;
