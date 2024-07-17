// job.model.ts
export interface Job {
  jobPosId?: number;
  description: string;
  minExp: number;
  minSal: number;
  maxSal: number;
  isActive: boolean;
  designation: string;
  createdBy: number;
  deadline: string;
  locations: number[];
  codingLanguages: number[];
}

export interface CodingLanguage {
  id: number;
  langName: string;
  skill: string;
}

export interface LanguageGroup {
  langName: string;
  skills: CodingLanguage[];
}