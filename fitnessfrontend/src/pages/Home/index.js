import React from "react";
import ClubCard from "../../components/ClubCard";
import Crossfit from "../../components/Crossfit";
import CrossfitBanner from "../../components/CrossfitBanner";
import OutTrainer from "../../components/OutTrainer";
import Post from "../../components/Post";
import Program from "../../components/Program";
import { CrossfitSlider } from "../../components/Slider";
import Testimonial from "../../components/Testimonial";
import TrainingSchedule from "../../components/TrainingSchedule";
export default function Home() {
  return (
    <>
      <CrossfitSlider />
      <Crossfit />
      <Program />
      <OutTrainer />
      <CrossfitBanner />
      <ClubCard />
      {/* <Testimonial /> */}
      <Post />
      <TrainingSchedule />
    </>
  );
}
