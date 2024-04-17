import Faq from '@/components/about/FAQ';

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
        <h1 className="text-center font-semibold text-3xl mb-4">Our Story</h1>
        <p className="text-lg">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit assumenda
          velit eaque nobis ex minima natus eligendi esse! Rem dolor est Lorem
          ipsum dolor Lorem ipsum dolor sit amet consectetur, adipisicing elit.
          Iure aliquid deserunt quidem iste sequi nostrum beatae incidunt non
          officiis fugiat animi veniam, aliquam perspiciatis accusamus natus
          neque rerum cum quisquam! Lorem ipsum dolor sit amet consectetur
          adipisicing elit. Illum aliquid odit quod similique in, rerum, minima
          sunt assumenda natus distinctio nam quam laborum eius deleniti.
          Deserunt non expedita eum labore. Lorem ipsum, dolor sit amet
          consectetur adipisicing elit. Asperiores, dignissimos? Beatae nihil
          enim pariatur sapiente ullam, quaerat magni rerum, architecto nam quos
          blanditiis aliquid! Recusandae sed et dolore debitis quos.
        </p>
      </div>
    </section>
  );
};

export default AboutPage;
