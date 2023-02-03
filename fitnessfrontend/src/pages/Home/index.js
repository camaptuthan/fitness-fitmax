import React from "react";
import Crossfit from "../../components/Crossfit";
import OutTrainer from "../../components/OutTrainer";
import Program from "../../components/Program";
import { CrossfitSlider } from "../../components/Slider";
export default function Home() {
  return (
    <>
      <CrossfitSlider />
      <Crossfit />
      <Program />
      <OutTrainer />
    </>
  );
}
